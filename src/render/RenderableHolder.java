package render;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RenderableHolder {

	private static final RenderableHolder instance = new RenderableHolder();
	private List<IRenderable> entities;
	
	public static RenderableHolder getInstance() {
		return instance;
	}

	public RenderableHolder() {
		super();
		// TODO Auto-generated constructor stub
		entities = new ArrayList<IRenderable>();
	}
	
	public void add(IRenderable entity){
		entities.add(entity);
		//Sort our list by Z
		Collections.sort(entities, new Comparator<IRenderable>() {
			@Override
			public int compare(IRenderable o1, IRenderable o2) {
				if(o1.getZ() > o2.getZ()) return 1;
				return -1;
			}
		});
	}
	
	public void removeAll() {
		entities.clear();
	}

	public List<IRenderable> getRenderableList() {
		return entities;
	}
	
	
}
