package com.vinsys.app;

import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

public abstract class BasePage extends WebPage {

	public BasePage() {
		
		/*ModalWindow*/
		Link moviesLink = new Link("movies") {

			@Override
			public void onClick() {
				setResponsePage(MoviesPage.class);
			}
		};

		Link tvLink = new Link("television") {

			@Override
			public void onClick() {
				setResponsePage(TelevisionPage.class);
			}
		};

		Link eventLink = new Link("events") {

			@Override
			public void onClick() {
				setResponsePage(EventsPage.class);
			}
		};
		
		Link loginLink = new Link("login", new Model("Login")) {

			@Override
			public void onClick() {
				setResponsePage(LoginPage.class);
			}
		};
		
		add(moviesLink);
		add(tvLink);
		add(eventLink);
		add(loginLink);
	}

}
