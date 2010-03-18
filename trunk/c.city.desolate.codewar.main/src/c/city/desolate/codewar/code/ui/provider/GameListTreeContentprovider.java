package c.city.desolate.codewar.code.ui.provider;

import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import c.city.desolate.codewar.code.ui.bean.GameTreeElement;

public class GameListTreeContentprovider implements ITreeContentProvider{

	@Override
	public Object[] getChildren(Object parentElement) {
		return ((GameTreeElement)parentElement).getChildren().toArray();
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return ((GameTreeElement)element).hasChildren();
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return ((List)inputElement).toArray();
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		
	}
	
}
