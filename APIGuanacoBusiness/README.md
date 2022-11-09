<h2 ><a href="https://choripan.studio"><img alt="guanaco logo" src="https://pbs.twimg.com/media/FXK9NsdWAAA99p-?format=png&name=small" height="120" /> </a>REST API Guanaco Business  </h2>

This API will be in charge of carrying out all the processes related to the type of call to the database that you want to make (CRUD) of the Guanaco Business application.

All the main files are in `src`.

## Table of Contents

- [Run Api](#run-api)
- [Host Deployment](#deployment-in-a-host-server)
  - [Create a new droplet](#create-a-new-droplet)
  - [Configure server](#configure-server)
  - [Add API](#add-api)
  - [Run API in the host server](#run-api-in-the-host-server)

## Run API
If we wanted to initialize the API on our localhost, we first need to install **node modules**

    npm install
    
By default it is set to port 9000, but you can set any port as long as it is not in use in the `app.js` file, having all that ready now we can run the API

    npm run start
 
![connectionSuccess](ApiConnection.PNG)

Now you can make API requests using your `localhost:port`

# Deployment in a Host server

Now we have our functional API, we need a server in the cloud to host our API, to be able to do maintenance, configurations and security, there are a lot of pages that offer this hosting service, in this case we use [DigitalOcean](https://www.digitalocean.com)

### Create a new droplet
Open the "Create" drop-down menu and click the "Droplets"

![createDroplet](https://pbs.twimg.com/media/FXK9c4OXkAELN32?format=png&name=small)

Select the Ubuntu operating system. And choose the plan that you consider best, it is recommended to configure it as a general purpose for best performance.

![configure_droplet](https://pbs.twimg.com/media/FXK9jFTXoAEW45N?format=png&name=large)

It is recommended to configure the droplet with an SSH Key for security reasons

![ssh_key](https://pbs.twimg.com/media/FXK9yzHWYAEd0Xr?format=png&name=900x900)

The configuration is done, now we can click on the "Create Droplet" button.

### Configure server 

We login to the console, we can use the console that DigitalOcean provides, and we need to update the operating system
```
sudo apt-get update
```
```
sudo apt dist-upgrade
reboot
```

With the updated system, we can start configuring the server's firewall, so that no part of the server can be accessed except the API, allow the SSH key we created earlier and allow the port that you configure in `app.js` to be accessed, and this case the port is 9000.

    sudo ufw default deny incoming
    sudo ufw default allow outgoing
    sudo ufw allow ssh
    sudo ufw allow 9000/tcp
    ufw enable

### Add Api

The firewall is ready to be used, now we can add the API to the server, just clone the repository:

```
git clone https://github.com/UCASV/poryecto-guanacobusiness.git
```

Then we can go to the folder and install the node modules, but first we need to install the `npv` Node Version Manager, we can install it using the following command:

```
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.1/install.sh | bash
```

now we can install the node version we want, in this case we want to use the latest version of node:

```
nvm install --lts
```

npm is ready, go to the folder and install the node modules:

```
npm install
```

The API is ready for the use.

### Run API in the host server
Now we can run the api on the server by going into the `src` project folder and running the command:
    
```
npm run start
 ```

but if we close the console, the API will shutdown, so first we need to install the `pm2` package manager, we can install it using the following command:
    
```
npm install pm2 -g
 ```

 And now we can run the API and keep going running it after close the console with this command:

 ```
    pm2 start app.js 
 ```

 Our API is ready!, now we can make API requests using `your_ip_droplet:port` and our case is [our droplet](http://188.166.37.93:9000)
