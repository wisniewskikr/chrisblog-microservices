package pl.kwi.chrisblog.services;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pl.kwi.chrisblog.clients.TagClient;
import pl.kwi.chrisblog.commands.list.ListCommand;
import pl.kwi.chrisblog.dtos.TagResponse;

@Service
public class TagService {

	private final TagClient tagClient;

	public TagService(TagClient tagClient) {
		this.tagClient = tagClient;
	}

	public void findAll(ListCommand command) {

		String searchText = null;
		if(StringUtils.isNotBlank(command.getSearchText())) {
			searchText = command.getSearchText().toLowerCase();
		}

		TagResponse tagResponse = tagClient.findTags(Long.valueOf(command.getSelectedCategory()), command.getSelectedTag(), command.getCurrentPage() - 1, command.getSelectedSorting(), searchText);
		command.setTags(tagResponse.tags());
	}
	
}
