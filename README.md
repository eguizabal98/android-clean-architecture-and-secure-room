# Android clean architecture example with secure DB

Example of a multi-module application with clean architecture implementing a database with room encrypted with the cipher sql library.

Dependency injection with koin

Navigation between fragments with navigation component and safe args

Encryption of the database with sqlcipher and seed phrase injection with native code in c ++ to complicate the reverse engineering to obtain it.

## Libraries used

Room Android \
Navigation Component\
Safe Args\
SQLCipher\
koin

## Difference when opening database file

Data Base File insecure in Hex viewer.

<img height="300" src="insecure hex data base.png" alt="insecure DB"/>

Data Base File secure in Hex viewer.

<img height="300" src="secure hex data base.png" alt="insecure DB"/>

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)
