package com.choiceofgames.choicescript.kindle;

/** 
 * This group binds together multiple radio buttons,
 * ensuring that only one radio button is selected at a time.
 * @author dfabulich
 *
 */
public class KCustomCheckboxGroup {
	private KCustomCheckbox selected = null;

	/** The currently selected radio button */
	public KCustomCheckbox getSelected() {
		return selected;
	}

	/** Select a radio button, deselecting the previously selected button */
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
