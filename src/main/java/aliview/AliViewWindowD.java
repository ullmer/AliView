// Extensions to AliViewWindow to provide distributed & Py4j functionalities
// Brygg Ullmer, Clemson University
// Begun 2024-08-05
// Py4J extensions begun 2024-09-20

package aliview;

import java.io.File;

import javax.swing.Action;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Color;

import aliview.gui.AliViewJMenuBarFactory;
import aliview.alignment.Alignment;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
//import java.util.logging.*;

import py4j.Gateway;
import py4j.GatewayServer;
import py4j.CallbackClient;
import py4j.Py4JPythonClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

//////////////////// AliView Window : Distributed & Py4j extensions (perhaps rename with DP suffix) //////////////////// 

public class AliViewWindowD extends AliViewWindow {
  protected boolean py4jActivated = true;
  protected boolean verbose       = true;
  //protected String         p4jServerIpAddressStr = "172.25.49.14"; // obviously requires more graceful integration 
  protected String         p4jServerIpAddressStr = "127.0.0.1";
  protected InetAddress    p4jServerIpAddress;
  protected GatewayServer  p4jGwServer;
  protected CallbackClient p4jCbClient;
  protected Logger         loggerP4J;

  private static final Logger loggerD = Logger.getLogger(AliViewWindow.class);

  
  //private ScrollBarModelSyncChangeListenerD scrollBarListenerD; // compile issues 2024-09-21

  //////////////////// constructor //////////////////// 

  public AliViewWindowD(File alignmentFile, AliViewJMenuBarFactory menuBarFactory) {
    super(alignmentFile, menuBarFactory);
    loggerD.info("AliViewWindowD invoked");

    if (py4jActivated) {launchPy4jServer();}
  }

  public void err(String msg) {System.out.println("AliViewWindowD error: " + msg);} // probably remap to Logger
  public void msg(String msg) {System.out.println("AliViewWindowD msg: "   + msg);}

  //public static void createNewAliViewWindowD() {
  //  msg("createNewAliViewWindowD called");
  //  createNewAliViewWindow();
  //}

  //////////////////// AliView Window : Distributed & Py4j extensions (perhaps rename with DP suffix) //////////////////// 

  public boolean launchPy4jServer() {
    try {
      if (verbose) {
        loggerP4J = Logger.getLogger("py4j");
        //loggerPRJ.setLevel(Level.ALL);
      }

      p4jServerIpAddress = InetAddress.getByName(this.p4jServerIpAddressStr);
      p4jCbClient        = new CallbackClient(GatewayServer.DEFAULT_PYTHON_PORT,
        InetAddress.getByName(CallbackClient.DEFAULT_ADDRESS), 2, TimeUnit.SECONDS);

      p4jGwServer = new GatewayServer(this, 25333, this.p4jServerIpAddress,
         GatewayServer.DEFAULT_CONNECT_TIMEOUT, GatewayServer.DEFAULT_READ_TIMEOUT,
         null, p4jCbClient);

      //if (verbose) { p4jGwServer.turnLoggingOn(); }

      p4jGwServer.start();
      return true; // successfully started

    } catch (Exception e) {err("AliViewWindowD launchPy4jServer exception: "); e.printStackTrace(System.out); System.exit(-1);}
    return false;
  }

  public void moveCursorUp(boolean isShiftDown)    {super.moveCursorUp(isShiftDown);    loggerD.info("AVWD moveCursorUp");}
  public void moveCursorDown(boolean isShiftDown)  {super.moveCursorDown(isShiftDown);  loggerD.info("AVWD moveCursorDown");}
  public void moveCursorLeft(boolean isShiftDown)  {super.moveCursorLeft(isShiftDown);  loggerD.info("AVWD moveCursorLeft");}
  public void moveCursorRight(boolean isShiftDown) {super.moveCursorRight(isShiftDown); loggerD.info("AVWD moveCursorRight");}

  public void setSize(int w, int h) {
    Dimension d = new Dimension(w, h);
    setSize(d);
  }

  public void setBackground(int r, int g, int b, int a) {
    Color c = new Color(r,g,b,a);
    setBackground(c);
  }

//  Action closeWinAction = new AbstractAction() { //compile issues 2024-09-21
//     public void actionPerformed(ActionEvent e) {
//       AliView.closeWindow(aliViewWindowD);
//     }
//  };

  //private void initWindow(Alignment newAlignment) {

//  protected void initWindow(Alignment newAlignment) { //compile issues 2024-09-21
//    loggerD.info("AliViewWindowD initWindow intercept called");
//    super.initWindow(newAlignment);
//    scrollBarListenerD = new ScrollBarModelSyncChangeListenerD(listScrollPane.getVerticalScrollBar().getModel());
//    alignmentScrollPane.getVerticalScrollBar().getModel().addChangeListener( scrollBarListenerD );
//    sequenceJList.addSynchPanes(listScrollPane, alignmentScrollPane);
//  }

/*
  public void zoomInAt(Point mousePos){
    super.zoomInAt(mousePos);
  }
  */
/*
  public void moveSelectedToBottom() {
    aliViewWindow.getUndoControler().pushUndoState(new UndoSavedStateSequenceOrder(alignment.getSequences().getDelegateSequencesCopy(), alignment.getAlignentMetaCopy()));
    alignment.moveSelectedSequencesToBottom();
    //requestPaneAndListRepaint();
    //alignmentPane.validateSize();
  }

  public void moveSelectedToTop() {
    aliViewWindow.getUndoControler().pushUndoState(new UndoSavedStateSequenceOrder(alignment.getSequences().getDelegateSequencesCopy(), alignment.getAlignentMetaCopy()));
    alignment.moveSelectedSequencesToTop();
    //requestPaneAndListRepaint();
    //alignmentPane.validateSize();
  }

  //public void moveSelectedDown() 
*/
}
/// end ///
