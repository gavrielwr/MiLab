const express = require('express');
const fs = require('fs')
const app = express();

app.get('/files/:filename', (req, res) => { //get the file. write file name with '.format'
    let filename = req.params['filename']
    fs.exists(`./files/${filename}`, (exists) => {
        if (exists) {
        let rdstream = fs.createReadStream(`./files/${filename}`);
        rdstream.pipe(res); 
        } else {
        res.end(`"${filename}" does not exist in the directory`);
        }
    });    
});

 app.get('*', (req, res) => {  
        res.end(`"${filename}" does not exist in the directory`);
});


app.listen(8080, () => console.log(`Server is running on port 8080`));