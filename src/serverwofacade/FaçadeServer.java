/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverwofacade;

/**
 *
 * @author black
 */
public class FaçadeServer {
    private static FaçadeServer myFacade = null;
    private FaçadeServer() {}
    public static FaçadeServer get() {
        if (myFacade == null) {
            myFacade = new FaçadeServer();
        }
        return myFacade;
    }
    public void start() {
        ScheduleServer scheduleServer = new ScheduleServer();
	scheduleServer.startBooting();
	scheduleServer.readSystemConfigFile();
	scheduleServer.init();
	scheduleServer.initializeContext();
	scheduleServer.initializeListeners();
	scheduleServer.createSystemObjects();
    }
    
    public void stop() {
        ScheduleServer scheduleServer = new ScheduleServer();
	scheduleServer.releaseProcesses();
	scheduleServer.destory();
	scheduleServer.destroySystemObjects();
	scheduleServer.destoryListeners();
	scheduleServer.destoryContext();
	scheduleServer.shutdown();
    }
}
