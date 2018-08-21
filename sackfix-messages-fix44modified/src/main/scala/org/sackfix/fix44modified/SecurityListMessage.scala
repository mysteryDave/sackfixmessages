package org.sackfix.fix44modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.modified.xml
  */
case class SecurityListMessage(securityReqIDField:SecurityReqIDField,
                               securityResponseIDField:SecurityResponseIDField,
                               securityRequestResultField:SecurityRequestResultField,
                               totNoRelatedSymField:Option[TotNoRelatedSymField]=None,
                               lastFragmentField:Option[LastFragmentField]=None,
                               noRelatedSymField:Option[NoRelatedSymField]=None,
                               relatedSymGroups: Option[List[RelatedSymGroup]]=None) extends SfFixMessageBody("y")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noRelatedSymField.map(_.value).getOrElse(0) != relatedSymGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoRelatedSymField.TagId,noRelatedSymField.map(_.value).getOrElse(0), relatedSymGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,securityReqIDField)
    fmt(b,securityResponseIDField)
    fmt(b,securityRequestResultField)
    totNoRelatedSymField.foreach(fmt(b,_))
    lastFragmentField.foreach(fmt(b,_))
    noRelatedSymField.foreach(fmt(b,_))
    relatedSymGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object SecurityListMessage extends SfFixMessageDecoder {
  val MsgType="y"
  val MsgName="SecurityList"
             
  override val MandatoryFields = HashSet[Int](
    SecurityReqIDField.TagId, SecurityResponseIDField.TagId, SecurityRequestResultField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    RelatedSymGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    TotNoRelatedSymField.TagId, LastFragmentField.TagId, NoRelatedSymField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    RelatedSymGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    RelatedSymGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoRelatedSymField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==SecurityReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(SecurityListMessage(SecurityReqIDField.decode(myFields.get(SecurityReqIDField.TagId)).get,
        SecurityResponseIDField.decode(myFields.get(SecurityResponseIDField.TagId)).get,
        SecurityRequestResultField.decode(myFields.get(SecurityRequestResultField.TagId)).get,
        myFields.get(TotNoRelatedSymField.TagId).flatMap(f=>TotNoRelatedSymField.decode(f)),
        myFields.get(LastFragmentField.TagId).flatMap(f=>LastFragmentField.decode(f)),
        myFields.get(NoRelatedSymField.TagId).flatMap(f=>NoRelatedSymField.decode(f)),
        if (nextTagPosLookup.contains(NoRelatedSymField.TagId)) RelatedSymGroup.decode(flds, nextTagPosLookup(NoRelatedSymField.TagId)) else None))
    } else None
  }

    
}
     