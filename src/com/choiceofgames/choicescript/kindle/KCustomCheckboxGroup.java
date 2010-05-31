package com.choiceofgames.choicescript.kindle;


public class KCustomCheckboxGroup {
	private KCustomRadioButton selected = null;

	public KCustomRadioButton getSelected() {
		return selected;
	}

	public void setSelected(KCustomRadioButton box) {
		if (box != null && box.group != this) {
		    return;
		}
		KCustomRadioButton oldChoice = this.selected;
		this.selected = box;
		if (oldChoice != null && oldChoice != box && oldChoice.group == this) {
		    oldChoice.setSelected(false);
		}
		if (box != null && oldChoice != box && !box.isSelected()) {
		    box.setSelected(true);
		}
	}
	
	
}
