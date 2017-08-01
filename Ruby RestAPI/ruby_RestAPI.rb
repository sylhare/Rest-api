# src -- http://www.andrewhavens.com/posts/20/beginners-guide-to-creating-a-rest-api/
require 'sinatra'
require 'JSON'
require 'widget' # our imaginary widget model

#For an an application that allows you to view, create, edit, and delete widgets

# list all widgets
get '/widgets' do
  # Would return all of the widget in a json format    
  Widget.all.to_json
end

# view one widget based on the id
get '/widgets/:id' do
  widget = Widget.find(params[:id])
  return status 404 if widget.nil? # HTTP error 404 Bad Gateway (not found) when no widget
  widget.to_json    # return the json of the parameter if it exists
end

# create a widget
post '/widgets' do
  widget = Widget.new(params['widget'])
  widget.save
  status 201 # return the HTTP success code 201 - Created
end

# update a widget
put '/widgets/:id' do
  widget = Widget.find(params[:id])
  return status 404 if widget.nil?
  widget.update(params[:widget])
  widget.save
  status 202 # return the HTTP success code 202 - Accepted
end

# Delete a widget
delete '/widgets/:id' do
  widget = Widget.find(params[:id])
  return status 404 if widget.nil?
  widget.delete
  status 202
end
