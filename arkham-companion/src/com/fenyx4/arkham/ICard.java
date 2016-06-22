package com.fenyx4.arkham;

import java.util.ArrayList;

public interface ICard {

	long getID();
	public ArrayList<Encounter> getEncounters();
	public ArrayList<Long> getExpIDs();
	public String getCardPath();
}
