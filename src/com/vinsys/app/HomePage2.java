package com.vinsys.app;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.JavascriptPackageResource;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.resources.CompressedResourceReference;
import org.apache.wicket.model.Model;

public class HomePage2 extends WebPage {

	/*public HomePage(PageParameters parameters) {
		super(parameters);
	}*/
	
	public HomePage2(){
		Label hello =new Label("hello_world","MAYANK Hello World");
		
		Link link =new Link("myLink") {

			@Override
			public void onClick() {
				setResponsePage(Greetings.class);				
			}
		};
		
		Form form = new Form("LoginForm");
		Model usernameModel= new Model();
		TextField usernameTextField = new TextField("username_text",usernameModel);
		Button button = new Button("formButton"){
			public void onSubmit(){
				System.out.println("you have just entered" + usernameModel.getObject());
				setResponsePage(Greetings.class);
			}
		};
		
		CompressedResourceReference compressedResourceReference =new CompressedResourceReference(HomePage2.class, "default.js");
		usernameTextField.add(new UsernameValidator2());
		form.add(usernameTextField);
		form.add(button);
		
		FeedbackPanel panel = new FeedbackPanel("errmsg") ;
		add(panel);
		
		add(JavascriptPackageResource.getHeaderContribution(compressedResourceReference));
		add(hello);
		add(link);
		add(form);
	}
}
