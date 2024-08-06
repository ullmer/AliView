package aliview;

import java.io.File;
import org.apache.log4j.Logger;
import aliview.gui.AliViewJMenuBarFactory;

public class AliViewWindowD extends AliViewWindow {
  private static final Logger loggerD = Logger.getLogger(AliViewWindow.class);

  public AliViewWindowD(File alignmentFile, AliViewJMenuBarFactory menuBarFactory) {
    super(alignmentFile, menuBarFactory);
    loggerD.info("AliViewWindowD invoked");
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
