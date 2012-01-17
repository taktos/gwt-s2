/**
 *
 */
package com.github.taktos.gwt.s2example.client;

import com.github.taktos.gwt.s2example.shared.Person;
import com.github.taktos.gwt.s2example.shared.PersonNotFoundException;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @author taktos
 *
 */
public class S2Example implements EntryPoint {

	/* (非 Javadoc)
	 * @see com.google.gwt.core.client.EntryPoint#onModuleLoad()
	 */
	public void onModuleLoad() {
		VerticalPanel panel = new VerticalPanel();
		HorizontalPanel searchPanel = new HorizontalPanel();

		Label nameLabel = new Label("Firstname:");
		final TextBox nameText = new TextBox();
		Button searchButton = new Button("Search");

		final Label label = new Label();

		searchButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				label.setText("");
				nameText.getElement().getStyle().clearBackgroundColor();

				PersonServiceAsync service = GWT.create(PersonService.class);
				service.getPerson(nameText.getValue(), new AsyncCallback<Person>() {

					public void onFailure(Throwable caught) {
						try {
							throw caught;
						} catch (PersonNotFoundException e) {
							nameText.getElement().getStyle().setBackgroundColor("red");
						} catch (Throwable e) {
							GWT.log("Unexpected error", e);
						}
					}

					public void onSuccess(Person result) {
						label.setText(result.getFirstName() + " " + result.getLastName());
					}
				});
			}
		});

		searchPanel.add(nameLabel);
		searchPanel.add(nameText);
		searchPanel.add(searchButton);

		panel.add(searchPanel);
		panel.add(label);

		RootPanel.get().add(panel);
	}

}
