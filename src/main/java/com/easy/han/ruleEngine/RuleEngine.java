package com.easy.han.ruleEngine;

/**
 * @author zhaohan
 */

public class RuleEngine {

    private Rule rule=new Rule();

    public boolean engine(UserType type,Command command){

        switch (command){
            case Sleep:
                boolean b=rule.sleep(type);
                return b;
            case Rm:
                boolean b1=rule.rm(type);
                return b1;
            case PowerOff:
                boolean b2=rule.powerOff(type);
                return b2;
            case Touch:
                boolean b3=rule.touch(type);
                return b3;
            case Cat:
                boolean b4=rule.cat(type);
                return b4;
            default:
                return true;
        }

    }

}

/**
 * @author zhaohan
 * UserType为用户种类的信息
 */
enum UserType{
    SUPERROOT,ROOT,LOCAL
}

/**
 * Command为所监控的各种信息
 */
enum Command{
    Sleep,Rm,PowerOff,Touch,Cat,Mv,Cp,More,Find,Chmod,Chown,Du,CornTab,Kill,Free,Top,Ping,Wegt
}

class Rule{

    public boolean sleep(UserType userType){
        if (userType==UserType.SUPERROOT){
            return true;
        }else if (userType==UserType.ROOT){
            return true;
        }else {
            return true;
        }
    }

    public boolean rm(UserType userType){
        if (userType==UserType.SUPERROOT){
            return true;
        }else if (userType==UserType.ROOT){
            return false;
        }else {
            return false;
        }
    }

    public boolean powerOff(UserType userType){
        if (userType==UserType.SUPERROOT){
            return true;
        }else if (userType==UserType.ROOT){
            return false;
        }else {
            return true;
        }
    }

    public boolean touch(UserType userType){
        if (userType==UserType.SUPERROOT){
            return true;
        }else if (userType==UserType.ROOT){
            return true;
        }else {
            return true;
        }
    }

    public boolean cat(UserType userType){
        if (userType==UserType.SUPERROOT){
            return true;
        }else if (userType==UserType.ROOT){
            return true;
        }else {
            return true;
        }
    }

}

