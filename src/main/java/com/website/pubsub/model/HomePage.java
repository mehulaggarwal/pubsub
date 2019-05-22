package com.website.pubsub.model;

import java.util.List;

public class HomePage {

	private List<Subscriber> subscribedChannels;
	private List<Channel> channelsCreated;

	public HomePage(List<Subscriber> subscribedChannels, List<Channel> channelsCreated) {
		super();
		this.subscribedChannels = subscribedChannels;
		this.channelsCreated = channelsCreated;
	}

	public HomePage() {
		super();
	}

	/**
	 * @return the subscribedChannels
	 */
	public List<Subscriber> getSubscribedChannels() {
		return subscribedChannels;
	}

	/**
	 * @param subscribedChannels
	 *            the subscribedChannels to set
	 */
	public void setSubscribedChannels(List<Subscriber> subscribedChannels) {
		this.subscribedChannels = subscribedChannels;
	}

	/**
	 * @return the channelsCreated
	 */
	public List<Channel> getChannelsCreated() {
		return channelsCreated;
	}

	/**
	 * @param channelsCreated
	 *            the channelsCreated to set
	 */
	public void setChannelsCreated(List<Channel> channelsCreated) {
		this.channelsCreated = channelsCreated;
	}

}
