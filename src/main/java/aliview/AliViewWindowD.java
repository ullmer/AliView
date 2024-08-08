package aliview;

import java.io.File;
import org.apache.log4j.Logger;
import aliview.gui.AliViewJMenuBarFactory;
import aliview.alignment.Alignment;

public class AliViewWindowD extends AliViewWindow {
  private static final Logger loggerD = Logger.getLogger(AliViewWindow.class);
  
  private ScrollBarModelSyncChangeListenerD scrollBarListenerD;

  public AliViewWindowD(File alignmentFile, AliViewJMenuBarFactory menuBarFactory) {
    super(alignmentFile, menuBarFactory);
    loggerD.info("AliViewWindowD invoked");
  }

  public void moveCursorUp(boolean isShiftDown)    {super.moveCursorUp(isShiftDown);    loggerD.info("AVWD moveCursorUp");}
  public void moveCursorDown(boolean isShiftDown)  {super.moveCursorDown(isShiftDown);  loggerD.info("AVWD moveCursorDown");}
  public void moveCursorLeft(boolean isShiftDown)  {super.moveCursorLeft(isShiftDown);  loggerD.info("AVWD moveCursorLeft");}
  public void moveCursorRight(boolean isShiftDown) {super.moveCursorRight(isShiftDown); loggerD.info("AVWD moveCursorRight");}

  private void initWindow(Alignment newAlignment) {
    loggerD.info("AliViewWindowD initWindow intercept called");
    super.initWindow(newAlignment);
    scrollBarListenerD = new ScrollBarModelSyncChangeListenerD(listScrollPane.getVerticalScrollBar().getModel());
    alignmentScrollPane.getVerticalScrollBar().getModel().addChangeListener( scrollBarListenerD );
    sequenceJList.addSynchPanes(listScrollPane, alignmentScrollPane);
  }

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
