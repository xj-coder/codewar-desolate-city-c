package platform.ui.focustraversalpolicy;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.util.Vector;

public class QFocusTraversalPolicy extends FocusTraversalPolicy {
	private Vector<Component> comps;

	public QFocusTraversalPolicy(Vector<Component> comps) {
		this.comps = comps;
	}

	@Override
	public Component getComponentAfter(Container aContainer, Component aComponent) {
		int idx = (comps.indexOf(aComponent) + 1) % comps.size();
		return comps.get(idx);
	}

	@Override
	public Component getComponentBefore(Container aContainer, Component aComponent) {
		int idx = comps.indexOf(aComponent) - 1;
		if (idx < 0) {
			idx = comps.size() - 1;
		}
		return comps.get(idx);
	}

	@Override
	public Component getDefaultComponent(Container aContainer) {
		return comps.get(0);

	}

	@Override
	public Component getFirstComponent(Container aContainer) {
		return comps.get(0);
	}

	@Override
	public Component getLastComponent(Container aContainer) {
		return comps.lastElement();
	}

}
