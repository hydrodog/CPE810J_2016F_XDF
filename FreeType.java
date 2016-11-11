// This document is just explaining how to use gdx-freetype in code.
/* And I have worked with my teammates to apply those definition and functions to the program.
 * 
 * FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/myfont.ttf"));
 * FreeTypeFontParameter parameter = new FreeTypeFontParameter();
 * parameter.size = 12;
 * BitmapFont font12 = generator.generateFont(parameter); // font size 12 pixels
 * generator.dispose(); // don't forget to dispose to avoid memory leaks! 
 * 
 * And we can display our own font by placing the font file in project's assets folder.
 * we will have to modify the first line of the above code and mention just our font file name in the parameters.
 * 
 * We have met some problems about display the Chinese characters on the screen. 
 * Below is what I think about solving this problem
 * 
 * public static FreeTypeFontGenerator Cfont = new FreeTypeFontGenerator( Gdx.files.internal("meow.ttf"));// add the font,
 * we need to add all the characters in the font , no repeat, or errors may occur.
 * public static FreeTypeBitmapFontData fontData = Cfont.generateData(25, FreeTypeFontGenerator.DEFAULT_CHARS+ "歌唱我们亲爱的祖国,从今走向繁荣富强", false);
 * 
 * font = new BitmapFont(Assets.fontData, Assets.fontData.getTextureRegion(), false);  
 * font.draw(game.batch, "歌唱我们亲爱的祖国,从今走向繁荣富强!", 100, 100);  // This is how we use the font
 * 
 * And I will test it and many other language font.

 */
 
 