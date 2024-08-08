package aliview.gui;



/**
 *        Synchronize the data models of any two JComponents that use a
 *         BoundedRangeModel ( such as a JScrollBar, JSlider or ProgressBar).
 *
 *        @see javax.swing.BoundedRangeModel
 *        @see javax.swing.event.ChangeListener
 *        @Author  R. Kevin Cole        
 */
public class ScrollBarModelSyncChangeListenerD extends ScrollBarModelSyncChangeListener
{
   public ScrollBarModelSyncChangeListenerD( BoundedRangeModel model ) { super.model(); }
   public void stateChanged( ChangeEvent e ){
      System.out.println("ScrollBarModelSyncChangeListenerD stateChanged:" + e);
      super.stateChanged(e);
   }
}
