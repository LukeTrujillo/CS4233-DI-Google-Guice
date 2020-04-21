/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Copyright ©2016-2020 Gary F. Pollice
 *******************************************************************************/
package guiced20;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import guiced20.service.*;

/**
 * This is where all of the binding will occur for the game. The VersionProvider
 * will be set before the test creates the injector. See DITests.java in the
 * text folder.
 * 
 * @version Mar 24, 2020
 */
public class GameBindingModule extends AbstractModule {
	/*
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {

		Class board = null;
		Class pieces = null;

		switch (VersionProvider.getVersionName()) {
		case "chess":
			board = ChessBoard.class;
			pieces = ChessPieces.class;
			break;
		case "stratego":
			board = StrategoBoard.class;
			pieces = StrategoPieces.class;
			break;
		}

		bind(BoardService.class).to(board);
		bind(PieceService.class).annotatedWith(Names.named("pieces")).to(pieces);

	}

}
