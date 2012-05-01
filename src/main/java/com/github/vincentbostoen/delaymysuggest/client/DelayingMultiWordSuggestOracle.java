package com.github.vincentbostoen.delaymysuggest.client;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;

public class DelayingMultiWordSuggestOracle extends MultiWordSuggestOracle {

	private static final int ZERO = 0;
    
    Timer suggestDelayTimer = new Timer() {
		@Override
		public void run() {
			DelayingMultiWordSuggestOracle.super.requestSuggestions(request, callback);
		}
	};
	private Request request;
	private Callback callback;
	private int currentDelay = ZERO;
	
	@Override
	public void requestSuggestions(Request request, Callback callback) {
		this.request = request;
		this.callback = callback;
		if(currentDelay > 0){	
			suggestDelayTimer.cancel();
			suggestDelayTimer.schedule(currentDelay);
		}else {
			super.requestSuggestions(request, callback);
		}
	}

	public void setDelay(int delay) {
		this.currentDelay = delay;
	}
	
	public int getDelay(){
		return this.currentDelay;
	}
}
