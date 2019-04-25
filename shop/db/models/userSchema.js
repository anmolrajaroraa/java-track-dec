const mongoose = require('../connection');
const schema = mongoose.Schema;
const userSchema = new schema({
    userid: {type: String, required: true, unique: true},
    password: {type: String, required: true}
})
const userModel = mongoose.model('users', userSchema);
module.exports = userModel;