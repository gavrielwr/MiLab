const express = require('express');
const app = express();
const server = require('http').createServer(app);
const io = require('socket.io')(server);
const port = process.env.PORT || 3000;
const alpha = require('alphavantage')({ key: 'DJWCUP8LAGJDFQ5P' });


server.listen(port, function () {
	console.log('Server is listening at port %d', port);
});


io.on('connection', function (socket) {
    // when the client emits 'stock type', this listens and executes
    socket.on('stock_price', function (name) {
        console.log('client requested a stock price');
        //every 10 sec
setInterval(()=>{
alpha.data.batch(['${name}']).then(data => {
  let price = `${data['Stock Quotes'][0]['2. price']}`;
  console.log(`${name} --> ${data['Stock Quotes'][0]['2. price']}`);

  io.emit('stock_price', { 
                price: price
            });

})
.catch(err=>{
	console.error("Error: " + err);

});

},10000);
});
});


