# -*- mode: ruby -*-
# vi: set ft=ruby :

# All Vagrant configuration is done below. The "2" in Vagrant.configure
# configures the configuration version (we support older styles for
# backwards compatibility). Please don't change it unless you know what
# you're doing.
Vagrant.configure("2") do |config|
  # The most common configuration options are documented and commented below.
  # For a complete reference, please see the online documentation at
  # https://docs.vagrantup.com.

  # Every Vagrant development environment requires a box. You can search for
  # boxes at https://vagrantcloud.com/search.
  #config.vm.box = "base"
  config.vm.box = "ubuntu/xenial64"

  config.vm.hostname = "twelve-factor-lab"
  # Disable automatic box update checking. If you disable this, then
  # boxes will only be checked for updates when the user runs
  # `vagrant box outdated`. This is not recommended.
  # config.vm.box_check_update = false

  # Create a forwarded port mapping which allows access to a specific port
  # within the machine from a port on the host machine. In the example below,
  # accessing "localhost:8080" will access port 80 on the guest machine.
  # NOTE: This will enable public access to the opened port
  # config.vm.network "forwarded_port", guest: 80, host: 8080

  # Create a forwarded port mapping which allows access to a specific port
  # within the machine from a port on the host machine and only allow access
  # via 127.0.0.1 to disable public access
  config.vm.network "forwarded_port", guest: 8000, host: 8000
  # Create a private network, which allows host-only access to the machine
  # using a specific IP.
  # config.vm.network "private_network", ip: "192.168.33.10"

  # Create a public network, which generally matched to bridged network.
  # Bridged networks make the machine appear as another physical device on
  # your network.
  # config.vm.network "public_network"

  # Share an additional folder to the guest VM. The first argument is
  # the path on the host to the actual folder. The second argument is
  # the path on the guest to mount the folder. And the optional third
  # argument is a set of non-required options.
  # config.vm.synced_folder "../data", "/vagrant_data"

  # Provider-specific configuration so you can fine-tune various
  # backing providers for Vagrant. These expose provider-specific options.
  # Example for VirtualBox:
  #
  config.vm.provider "virtualbox" do |vb|
  #   # Display the VirtualBox GUI when booting the machine
  #   vb.gui = true
  #
  #   # Customize the amount of memory on the VM:
  #   vb.memory = "1024"
     vb.memory = "2048"
     vb.cpus = 2
  end
  #
  # View the documentation for the provider you are using for more
  # information on available options.

  # Enable provisioning with a shell script. Additional provisioners such as
  # Puppet, Chef, Ansible, Salt, and Docker are also available. Please see the
  # documentation for more information about their specific syntax and use.
  config.vm.provision "shell", inline: <<-SHELL
    apt-get update

    apt-get install -y git

    apt-get install -y \
            linux-image-extra-$(uname -r) \
            linux-image-extra-virtual


    apt-get update

    apt-get install -y curl \
			apt-transport-https \
              		ca-certificates \
              		software-properties-common

    echo "add repo docker:"
    curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -

    add-apt-repository \
             "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
             $(lsb_release -cs) \
             stable"

    apt-get update

    echo "add repo docker-ce:"
    apt-get install -y docker-ce

    echo "Install python-pip:"
    apt-get -y install python-pip

    echo "Install docker-compose:"
    sudo pip install docker-compose

    # echo "Install AWSCli"
    # sudo pip install awscli

    echo "Install Java"
    curl -s https://download.java.net/java/GA/jdk11/9/GPL/openjdk-11.0.2_linux-x64_bin.tar.gz --output openjdk-11.0.2.tar.gz

    sudo mkdir -p /opt/java \
        && sudo tar -xvf openjdk-11.0.2.tar.gz -C /opt/java \
        && rm -rf openjdk-11.0.2.tar.gz

    echo "Install Maven"
    curl -s http://mirror.nbtelecom.com.br/apache/maven/maven-3/3.6.0/binaries/apache-maven-3.6.0-bin.tar.gz --output apache-maven-3.6.0-bin.tar.gz

    sudo mkdir -p /opt/maven \
          && sudo tar -xvf apache-maven-3.6.0-bin.tar.gz -C /opt/maven \
          && rm -rf apache-maven-3.6.0-bin.tar.gz

    sudo bash -c 'echo JAVA_HOME=/opt/java/jdk-11.0.2 >> /etc/environment'
    sudo bash -c 'echo PATH=$PATH:/opt/maven/apache-maven-3.6.0/bin:/opt/java/jdk-11.0.2/bin >> /etc/environment'

  SHELL
end
