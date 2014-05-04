The database format is the following. If you need separate database entries, let me know:

Images must manually be placed into /res/drawable, but will be added to their respective activities automatically.

All entries are ascii, and fields are separated by one blank line. Each activity is separated by 3 blank lines:
Field 1: List of images by file name without the extension, and the width and height of each image in dp, all semicolon separated, one image per line.
Field 2: List of variables, and their short and long names semi colon separated. semicolon. Units for each variable given, with up to one division symbol, and any number of units on each side of the division symbol separated by *’s, and with each individual unit allowed to have up to one “^#”, where # is the power of the exponent of that unit. # can be 2, or 3. Allowed unit symbols are (m,s,). Semicolon. Equations for solving for each variable, in the order of Field 2. references to other variables are of the form n#, where # is a literal number declaring which variable to reference (zero indexed in the order of field 2). One variable per line.
Field 3: Activity name, alpha only.
Field 4: Subheading for main activity;Entry name for main activity

See the test1.database file for an example.
