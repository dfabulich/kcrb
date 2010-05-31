/*
 * Copyright 2010 Dan Fabulich

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. 
 */

package com.choiceofgames.kindle;

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
