# lmr-msd
Java package for editing La-Mulana Remake .msd files.

Latest version: 0.1.0 (March 29, 2020)

Documentation coming soon, but in a nutshell:

1. Parse a .msd file using `MsdParse.parse(Path msdPath)` to get a `Stage` tree that contains the file's data.
2. Edit your stage tree data. The `Collision` and `Layer` classes have a functional-ish `TileMap` API which simplifies
editing their data.
3. Write your `Stage` back to a file using `MsdSerialize.serialize(Stage stage, Path filePath)`.

[Changelog](CHANGELOG.md)