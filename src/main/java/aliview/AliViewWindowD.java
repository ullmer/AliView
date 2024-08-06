package aliview;

public class AliViewWindowD extends AliViewWindow {


  public AliViewWindow(File alignmentFile, AliViewJMenuBarFactory menuBarFactory) {
        super(alignmentFile, menuBarFactory);
  }

  public void zoomInAt(Point mousePos){
    super.zoomInAt(mousePos);
  }
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
