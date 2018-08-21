package org.sackfix.fix44

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.xml
  */
case class NetworkStatusRequestMessage(networkRequestTypeField:NetworkRequestTypeField,
                                       networkRequestIDField:NetworkRequestIDField,
                                       noCompIDsField:Option[NoCompIDsField]=None,
                                       compIDsGroups: Option[List[CompIDsGroup]]=None) extends SfFixMessageBody("BC")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noCompIDsField.map(_.value).getOrElse(0) != compIDsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoCompIDsField.TagId,noCompIDsField.map(_.value).getOrElse(0), compIDsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,networkRequestTypeField)
    fmt(b,networkRequestIDField)
    noCompIDsField.foreach(fmt(b,_))
    compIDsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object NetworkStatusRequestMessage extends SfFixMessageDecoder {
  val MsgType="BC"
  val MsgName="NetworkStatusRequest"
             
  override val MandatoryFields = HashSet[Int](
    NetworkRequestTypeField.TagId, NetworkRequestIDField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    CompIDsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoCompIDsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    CompIDsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    CompIDsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoCompIDsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==NetworkRequestTypeField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(NetworkStatusRequestMessage(NetworkRequestTypeField.decode(myFields.get(NetworkRequestTypeField.TagId)).get,
        NetworkRequestIDField.decode(myFields.get(NetworkRequestIDField.TagId)).get,
        myFields.get(NoCompIDsField.TagId).flatMap(f=>NoCompIDsField.decode(f)),
        if (nextTagPosLookup.contains(NoCompIDsField.TagId)) CompIDsGroup.decode(flds, nextTagPosLookup(NoCompIDsField.TagId)) else None))
    } else None
  }

    
}
     