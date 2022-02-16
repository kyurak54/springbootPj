const path = require('path');

module.exports = {
    resolve: {
        alias: {
            // 상위경로/src/를 @로 대체
            '@': path.resolve(__dirname, 'src/')
        }
    }
};