terraform {
  backend "s3" {
    bucket = "terraform-suitecrm-state"
    key    = "core/terraform.tfstate"
    region = "eu-central-1"
  }
}
