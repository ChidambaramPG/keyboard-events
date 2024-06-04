var exec = require('cordova/exec');

var KeyPress = {
    onKeyPress: function(successCallback, errorCallback) {
        exec(successCallback, errorCallback, 'KeyPress', 'onKeyPress', []);
    }
};

module.exports = KeyPress;