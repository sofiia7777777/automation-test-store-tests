## module-10-improvements branch

This branch should be considered as the improved version of `module-10-design-patterns` and contains cleaner, more secure, and more maintainable code.

The main enhancements include:

- **Wait configuration externalized**
   - Timeout values were moved to property files for two environments: `dev` and `qa`.
   - A new class `WaitConfig` was introduced to provide access to these timeout values across the framework.

- **Guest checkout test data management**
   - A new JSON file `checkoutData.json` was added to store information required for guest checkout scenarios.
   - A new class `GuestCheckoutInfoReader` was implemented to read and deserialize this JSON content into Java objects.

- **Improved security for credentials**
   - Usernames and passwords were removed from property files.
   - Sensitive data is now provided via **environment variables**.
   - A dedicated class `CredentialsProvider` was introduced to safely retrieve the username and password when needed.
