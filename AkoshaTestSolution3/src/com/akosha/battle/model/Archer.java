package com.akosha.battle.model;


import java.util.ArrayList;

public class Archer
{
	private ArrayList<Arrow> arrows;

	public ArrayList<Arrow> getArrows()
	{
		return arrows;
	}

	public void setArrows(ArrayList<Arrow> arrows)
	{
		this.arrows = arrows;
	}
	
	public int getNumArrows()
	{
		return arrows.size();
	}
	
	public boolean hasMoreArrows()
	{
		return arrows.size() > 0;
	}
	
	public Arrow removeArrow()
	{
		return arrows.remove(0);
	}
	
	public void removeAllArrows()
	{
		arrows.clear();
	}
}
