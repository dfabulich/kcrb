package com.choiceofgames.choicescript.kindle;
import java.awt.Container;
import java.awt.FlowLayout;

import com.amazon.kindle.kindlet.AbstractKindlet;
import com.amazon.kindle.kindlet.KindletContext;
import com.amazon.kindle.kindlet.ui.KLabel;
public class SampleCustomRadioButton extends AbstractKindlet {    
	public void create(KindletContext context){        
		//Logger logger = Logger.getLogger(HelloWorld.class);
		Container rootContainer = context.getRootContainer();
		rootContainer.setLayout(new FlowLayout());
		
		KCustomCheckboxGroup group = new KCustomCheckboxGroup();
		
		rootContainer.add(new KCustomCheckbox(group));
		rootContainer.add(new KCustomCheckbox(group));
		rootContainer.add(new KCustomCheckbox(group));
		rootContainer.add(new KCustomCheckbox(group));
		rootContainer.add(new KCustomCheckbox(group));
		
		group = null;
		
		rootContainer.add(new KCustomCheckbox(group));
		rootContainer.add(new KCustomCheckbox(group));
		rootContainer.add(new KCustomCheckbox(group));
		rootContainer.add(new KCustomCheckbox(group));
		rootContainer.add(new KCustomCheckbox(group));
		
		KCustomCheckbox button = new KCustomCheckbox(group);
		rootContainer.add(button);
				
		button.requestFocus();
		rootContainer.add(new KLabel("fClick this option! g f I"));
	}
	
}
