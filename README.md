# jukebox-api
this project supports a single GET endpoint which returns a paginated list of jukeboxes that suppport a given setting id. It should support following query parameters:

* `settingId` - setting id (required)
* `model` - filter by model name (optional)
* `offset` - specifies at what index start the page (optional)
* `limit` - specifies the page size (optional)

you can find api documentation provided by openapi in http://localhost:8090/swagger-ui/index.html

