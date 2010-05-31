package com.choiceofgames.choicescript.kindle;


public class KCustomCheckboxGroup {
	private KCustomCheckbox selected = null;

	public KCustomCheckbox getSelected() {
		return selected;
	}

	public void setSelected(KCustomCheckbox box) {
		if (box != null && box.group != this) {
		    return;
		}
		KCustomCheckbox oldChoice = this.selected;
		this.selected = box;
		if (oldChoice != null && oldChoice != box && oldChoice.group == this) {
		    oldChoice.setSelected(false);
		}
		if (box != null && oldChoice != box && !box.isSelected()) {
		    box.setSelected(true);
		}
	}
	
	
}
