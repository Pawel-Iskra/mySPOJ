<table id="repo-files-table" class="ui unstackable fixed single line table">
	<thead>
		<tr>
			<th class="four wide">
				{{if .LatestCommitUser}}
					<img class="ui avatar image img-12" src="{{.LatestCommitUser.RelAvatarLink}}" />
					<a href="{{AppSubURL}}/{{.LatestCommitUser.Name}}"><strong>{{.LatestCommit.Author.Name}}</strong></a>
				{{else}}
					<img class="ui avatar image img-12" src="{{AvatarLink .LatestCommit.Author.Email}}" />
					<strong>{{.LatestCommit.Author.Name}}</strong>
				{{end}}
				<a rel="nofollow" class="ui sha label" href="{{.RepoLink}}/commit/{{.LatestCommit.ID}}" rel="nofollow">{{ShortSHA1 .LatestCommit.ID.String}}</a>
				<span class="grey has-emoji">{{RenderCommitMessage false .LatestCommit.Summary .RepoLink $.Repository.ComposeMetas | Str2HTML}}</span>
			</th>
			<th class="nine wide">
			</th>
			<th class="three wide text grey right age">{{TimeSince .LatestCommit.Author.When $.Lang}}</th>
		</tr>
	</thead>
	<tbody>
		{{if .HasParentPath}}
			<tr class="has-parent">
				<td colspan="3"><i class="octicon octicon-mail-reply"></i><a href="{{EscapePound .BranchLink}}{{.ParentPath}}">..</a></td>
			</tr>
		{{end}}
		{{range .Files}}
			<tr>
				{{if .Submodule}}
					<td>
						<span class="octicon octicon-file-submodule"></span>
						<a href="{{InferSubmoduleURL .Submodule}}">{{.Entry.Name}} @ {{ShortSHA1 .Submodule.Commit}}</a>
					</td>
				{{else}}
					<td class="name">
						{{if .Entry.IsSymlink}}
							<span class="octicon octicon-file-symlink-file"></span>
						{{else}}
							<span class="octicon octicon-file-{{if or .Entry.IsTree}}directory{{else}}text{{end}}"></span>
						{{end}}
						<a href="{{EscapePound $.TreeLink}}/{{EscapePound .Entry.Name}}">{{.Entry.Name}}</a>
					</td>
				{{end}}
				<td class="message collapsing has-emoji">
					<a rel="nofollow" class="ui sha label" href="{{$.RepoLink}}/commit/{{.Commit.ID}}">{{ShortSHA1 .Commit.ID.String}}</a>
					{{RenderCommitMessage false .Commit.Summary $.RepoLink $.Repository.ComposeMetas | Str2HTML}}
				</td>
				<td class="text grey right age">{{TimeSince .Commit.Committer.When $.Lang}}</td>
			</tr>
		{{end}}
	</tbody>
</table>
{{if and .ReadmeExist .IsTextFile}}
	{{template "repo/view_file" .}}
{{end}}
Note: the goal of the SPOJ tasks is to get the fastest solution possible. Therefore, coding is done to achieve this.
<br>
<br>Implementations:
<br>
<table>
   <tr>
      <td> </td> <td><B>Task name</td> <td><B>Usage</td>
   </tr>
   <tr>
      <td>1</td> <td>NWW2</td> <td>Euclidean algorithm</td>
   </tr>
   <tr>
      <td>2</td> <td>LiczbyPierwsze</td> <td>Sieve of Erathosthenes</td>
   </tr>
   <tr>
      <td>3</td> <td>BINOMS</td> <td>Binomial coefficient</td>
   </tr>
   <tr>
      <td>4</td> <td>Stefan</td> <td>Kadane's algorithm</td>
   </tr>
    <tr>
      <td>5</td> <td>MajatekBilla</td> <td>Fast modular exponentiation</td>
   </tr>
    <tr>
      <td>6</td> <td>Sort1</td> <td>Insertion Sort</td>
   </tr>
   <tr>
      <td>7</td> <td>BajtockieSwietoTrojkata</td> <td>Heron's formula</td>
   </tr>
   <tr>
      <td>8</td> <td>WspolliniowoscPunktow</td> <td>Determinant of square matrix</td>
   </tr>
    <tr>
      <td>9</td> <td>SystemyPozycyjne</td> <td>Convertion from decimal system to hexadecimal and eleventh systems</td>
   </tr>
   <tr>
      <td>10</td> <td>LENLCS</td> <td>Algorithm determining length of longest common subsequence</td>
   </tr>
   <tr>
      <td>11</td> <td>SzyfrGronsfelda</td> <td>Gronsfeld cipher</td>
   </tr>
   <tr>
      <td>12</td> <td>SumyWielokrotne</td> <td>Low level number reading</td>
   </tr>
   <tr>
      <td>13</td> <td>Flamaster</td> <td> </td>
   </tr>
   <tr>
      <td>14</td> <td>ZabawneDodawaniaPiotrusia</td> <td> </td>
   </tr>
   
</table>
