import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GHDSliderListener implements ChangeListener {

	private GHDFrame ghd;

	public GHDSliderListener(GHDFrame ghdFrame) {
		ghd = ghdFrame;
	}

	/**
	 * Tracks changes of the slider
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() instanceof JSlider) {
			JSlider js = (JSlider) e.getSource();
			if (js.getValueIsAdjusting()) {
				ghd.sliderText.setText(" " + ghd.slider.getValue() + "\t");
			}
		}
	}
}
