mkdir .aws;
echo -e "[default]\nregion = $AWS_DEFAULT_REGION\noutput = json" > .aws/config;
echo -e "[default]\naws_access_key_id = $AWS_ACCESS_KEY_ID\naws_secret_access_key = $AWS_SECRET_ACCESS_KEY" > .aws/credentials;
