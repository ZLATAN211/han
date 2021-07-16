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
            case Cp:
                boolean b5=rule.cp(type);
                return b5;
            case Du:
                boolean b6=rule.du(type);
                return b6;
            case Mv:
                boolean b7=rule.mv(type);
                return b7;
            case Top:
                boolean b8=rule.top(type);
                return b8;
            case Find:
                boolean b9=rule.find(type);
                return b9;
            case Free:
                boolean b10=rule.free(type);
                return b10;
            case Kill:
                boolean b11=rule.kill(type);
                return b11;
            case More:
                boolean b12=rule.more(type);
                return b12;
            case Ping:
                boolean b13=rule.ping(type);
                return b13;
            case Wegt:
                boolean b14=rule.wegt(type);
                return b14;
            case Chmod:
                boolean b15=rule.chmod(type);
                return b15;
            case Chown:
                boolean b16=rule.chown(type);
                return b16;
            case CornTab:
                boolean b17=rule.corntab(type);
                return b17;
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

    public boolean mv(UserType userType){
        if (userType==UserType.SUPERROOT){
            return true;
        }else if (userType==UserType.ROOT){
            return true;
        }else {
            return false;
        }
    }

    public boolean cp(UserType userType){
        if (userType==UserType.SUPERROOT){
            return true;
        }else if (userType==UserType.ROOT){
            return true;
        }else {
            return true;
        }
    }

    public boolean more(UserType userType){
        if (userType==UserType.SUPERROOT){
            return true;
        }else if (userType==UserType.ROOT){
            return true;
        }else {
            return true;
        }
    }

    public boolean find(UserType userType){
        if (userType==UserType.SUPERROOT){
            return true;
        }else if (userType==UserType.ROOT){
            return true;
        }else {
            return true;
        }
    }

    public boolean chmod(UserType userType){
        if (userType==UserType.SUPERROOT){
            return true;
        }else if (userType==UserType.ROOT){
            return false;
        }else {
            return false;
        }
    }

    public boolean chown(UserType userType){
        if (userType==UserType.SUPERROOT){
            return true;
        }else if (userType==UserType.ROOT){
            return false;
        }else {
            return false;
        }
    }

    public boolean du(UserType userType){
        if (userType==UserType.SUPERROOT){
            return true;
        }else if (userType==UserType.ROOT){
            return true;
        }else {
            return true;
        }
    }

    public boolean corntab(UserType userType){
        if (userType==UserType.SUPERROOT){
            return true;
        }else if (userType==UserType.ROOT){
            return false;
        }else {
            return false;
        }
    }

    public boolean kill(UserType userType){
        if (userType==UserType.SUPERROOT){
            return true;
        }else if (userType==UserType.ROOT){
            return false;
        }else {
            return false;
        }
    }

    public boolean free(UserType userType){
        if (userType==UserType.SUPERROOT){
            return true;
        }else if (userType==UserType.ROOT){
            return true;
        }else {
            return true;
        }
    }

    public boolean top(UserType userType){
        if (userType==UserType.SUPERROOT){
            return true;
        }else if (userType==UserType.ROOT){
            return true;
        }else {
            return true;
        }
    }

    public boolean ping(UserType userType){
        if (userType==UserType.SUPERROOT){
            return true;
        }else if (userType==UserType.ROOT){
            return true;
        }else {
            return true;
        }
    }

    public boolean wegt(UserType userType){
        if (userType==UserType.SUPERROOT){
            return true;
        }else if (userType==UserType.ROOT){
            return true;
        }else {
            return false;
        }
    }

}

