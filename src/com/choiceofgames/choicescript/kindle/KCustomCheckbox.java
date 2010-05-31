package com.choiceofgames.choicescript.kindle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.log4j.Logger;

import com.amazon.kindle.kindlet.ui.KButton;

public class KCustomCheckbox extends KButton implements ActionListener {
	
	private boolean selected = false;
	final KCustomCheckboxGroup group;

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		if (this.selected == selected) return;
		if (selected && group != null) group.setSelected(this);
		this.selected = selected;
		repaint();
	}

	private static final long serialVersionUID = 8105922331821759692L;
	private static Logger logger = Logger.getLogger(SampleCustomRadioButton.class);
	private static final int padding = 2, border = 2;
	public KCustomCheckbox() {
		this(null);
		
	}
	public KCustomCheckbox(KCustomCheckboxGroup group) {
		this.group = group;
		addActionListener(this);
	}
	
	public Dimension getPreferredSize() {
		return getMinimumSize();
	}
	
	public Dimension getMinimumSize() {
		int d = getFontMetrics(getFont()).getMaxAscent();
		d += (padding + border) * 2 + 2;
		logger.info("declared minimum: " + d);
		return new Dimension(d, d);
	}
	
	public void paint(Graphics g) {
		logger.info("I'm painting");
		//super.paint(g);
		 // Dynamically calculate size information
        Dimension size = getSize();
        int maxAscent = g.getFontMetrics().getMaxAscent();
		int d = maxAscent;
        // diameter
        //int d = Math.min(size.width, size.height);
        //d = Math.min(30, d);
        //d = Math.max(20, d);
        int x = padding + border;
        int y = padding + border;
        logger.info("size.width " + size.width);
        logger.info("size.height " + size.height);
        logger.info("x " + x);
        logger.info("y " + y);
        logger.info("d " + d);

        g.setColor(Color.black);
        if (group != null) {
        	if (selected) g.fillOval(x, y, d, d);
            g.drawOval(x, y, d, d);
            logger.info("g.drawOval(x, y, d, d);" + x + "," + y + "," + d);
        } else {
        	if (selected) {
        		// draw X
        		g.drawLine(x, y, x+d, y+d);
        		g.drawLine(x, y+d, x+d, y);
        	}
            g.drawRect(x, y, d, d);
        }
        
        if (!isFocusOwner()) {
        	g.setColor(Color.white);
        }
        for (int i = 0; i < border; i++) {
        	int rectWidth = d+padding*2+border*2-i*2;
        	logger.info("g.drawRect(i, i, rectWidth, rectWidth);" + i + "," + rectWidth);
        	g.drawRect(i, i, rectWidth, rectWidth);
        }
	}

	public void actionPerformed(ActionEvent e) {
		setSelected(!selected);
	}
	
	
}
