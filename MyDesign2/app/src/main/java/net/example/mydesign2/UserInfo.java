package net.example.mydesign2;

public class UserInfo {
    private static UserInfo mUserInfo;

    public synchronized static UserInfo getinstance() {
        if (mUserInfo == null) {
            mUserInfo = new UserInfo();
        }
        return mUserInfo;
    }

    public String name="";
    public String num="";
    public String classname="";
    public String address="";
    public int selectradioId=R.id.radio_kaoyan;
    public String selectradioText="";
    public String plant="";

    @Override
    public String toString() {
        return "" + name +
                "#" + num +
                "#" + classname +
                "#" + address +
                "#" + selectradioId +
                "#" + selectradioText +
                "#" + plant ;
    }
}
