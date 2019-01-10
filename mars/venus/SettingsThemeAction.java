package mars.venus;
import mars.simulator.*;
import mars.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

/**
 * Action class for the Settings menu item to change the UIManager look and feel / theme.
 */
public class SettingsThemeAction extends GuiAction
{


	public SettingsThemeAction(String name, Icon icon, String descrip,
							   Integer mnemonic, KeyStroke accel, VenusUI gui)
	{
		super(name, icon, descrip, mnemonic, accel, gui);
	}

	public void actionPerformed(ActionEvent e)
	{
        // an action will never be performed; only on submenus
	}

}