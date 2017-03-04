

#ifndef DEMO_SERVICE_ICE
#define DEMO_SERVICE_ICE

[["java:package:com.bow"]]

module api{

    interface DataListener{
        void changeState(int state);
    };

    interface DemoService{
        void say(string s);
        int calculate(int a, int b);
        void subscribe(DataListener* listener);
        int async(int a);
    };


};


#endif