# simple render server

Simple server to render 2d and 3d floorplanner projects.

## environment variables

AWS credentials for roomstyler are needed.

    AWS_ACCESS_KEY_ID
    AWS_SECRET_ACCESS_KEY
    AWS_EC2_REGION

Should be set to ```rooms-2d```

    WORKER_QUEUE

The API-KEY for user tim@floorplanner.com

    FP_API_KEY

## install

    npm install

## run

    coffee src/main.coffee

Surf to [http://box.floorplanner.com:5001/](http://box.floorplanner.com:5001)
