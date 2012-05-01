package com.github.vincentbostoen.delaymysuggest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class DelayMySuggest implements EntryPoint {

	public void onModuleLoad() {
		RootLayoutPanel.get().add(new Suggester());
	}
}
