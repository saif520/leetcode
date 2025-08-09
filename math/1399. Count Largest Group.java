const mongoose=require('mongoose');
const {Schema}=mongoose;
const bcrypt=require('bcrypt');

const userSchema=new Schema({
    firstName:String,
    lastName:String,
    username:{type:String,required:true},
    password:{type:String,required:true}
})

userSchema.pre("save",async function(next){
    const user=this;
    if(!user.isModified('password')) return next();
    
})

const User=mongoose.model("User",userSchema);

module.exports=User;