package com.vinsys.app;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.DataGridView;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.PropertyPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

public class LoginPage extends BasePage{
	
	public LoginPage(){
		
		ModalWindow helpWindow = new ModalWindow("help");
		helpWindow.setPageCreator(new ModalWindow.PageCreator() {
			
			@Override
			public Page createPage() {
				return new CopyrightPage();
			}
		});
		
		helpWindow.setTitle(new Model("Help"));
		helpWindow.setOutputMarkupId(true);
		AjaxLink help = new AjaxLink("helpLink") {

			@Override
			public void onClick(AjaxRequestTarget target) {
				helpWindow.show(target);
				
			}
		};
		User user = new User();
		FeedbackPanel feedbackPanel = new FeedbackPanel("errMsg");
		Form loginForm = new Form("loginform");
		Label usernameLabel = new Label("usernameLabel");
		Label passwordLabel = new Label("passwordLabel");
		TextField usernameTextfield = new TextField("username", new PropertyModel(user, "username"));
		usernameTextfield.add(new UsernameValidator());
		PasswordTextField passwordtextField = new PasswordTextField("password", new PropertyModel(user, "password"));
		usernameTextfield.setRequired(true);
		passwordtextField.setRequired(true);
		
		Button loginButton = new Button("loginButton"){
			@Override
			public void onSubmit(){
				super.onSubmit();
				System.out.println("handle all the login concerns here");
				/*getApplication().getSessionStore().setAttribute(getRequest(), "logged_in", "logged_in");*/
				System.out.println(user.getUsername() + " " + user.getPassword());
				setResponsePage(HomePage.class);
			}
		};
		
		loginForm.add(usernameLabel);
		loginForm.add(passwordLabel);
		loginForm.add(usernameTextfield);
		loginForm.add(passwordtextField);
		loginForm.add(loginButton);
		add(help);
		add(helpWindow);
		add(loginForm);
		add(feedbackPanel);
		
		IColumn[] columns2 = new IColumn[2];
		columns2[0] = new PropertyColumn(new Model("Username"),"Username","Username");
		columns2[1] = new PropertyColumn<>(new Model("Password"), "Password", "Password");
		DefaultDataTable table = new DefaultDataTable("datatable", columns2, new UserDataProvider(), 10);
		add(table);
		
		List<ICellPopulator<User>> columns = new ArrayList<>();
		columns.add(new PropertyPopulator<User>("Username"));
		columns.add(new PropertyPopulator<User>("Password"));
		DataGridView view = new DataGridView("rows", columns, new UserDataProvider());
		add(view);
	}
}
